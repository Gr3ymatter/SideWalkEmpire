
package com.esotericsoftware.spine;

import com.esotericsoftware.spine.Animation.AttachmentTimeline;
import com.esotericsoftware.spine.Animation.ColorTimeline;
import com.esotericsoftware.spine.Animation.CurveTimeline;
import com.esotericsoftware.spine.Animation.RotateTimeline;
import com.esotericsoftware.spine.Animation.ScaleTimeline;
import com.esotericsoftware.spine.Animation.Timeline;
import com.esotericsoftware.spine.Animation.TranslateTimeline;
import com.esotericsoftware.spine.attachments.RegionAttachment;
import com.esotericsoftware.spine.attachments.RegionSequenceAttachment;
import com.esotericsoftware.spine.attachments.RegionSequenceAttachment.Mode;
import com.esotericsoftware.spine.attachments.TextureAtlasAttachmentLoader;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.badlogic.gdx.utils.OrderedMap;
import com.badlogic.gdx.utils.SerializationException;

public class SkeletonJson {
	static public final String TIMELINE_SCALE = "scale";
	static public final String TIMELINE_ROTATE = "rotate";
	static public final String TIMELINE_TRANSLATE = "translate";
	static public final String TIMELINE_ATTACHMENT = "attachment";
	static public final String TIMELINE_COLOR = "color";

	private final Json json = new Json();
	private final AttachmentLoader attachmentLoader;
	private float scale = 1;

	public SkeletonJson (TextureAtlas atlas) {
		attachmentLoader = new TextureAtlasAttachmentLoader(atlas);
	}

	public SkeletonJson (AttachmentLoader attachmentLoader) {
		this.attachmentLoader = attachmentLoader;
	}

	public float getScale () {
		return scale;
	}

	/** Scales the bones, images, and animations as they are loaded. */
	public void setScale (float scale) {
		this.scale = scale;
	}

	public SkeletonData readSkeletonData (FileHandle file) {
		if (file == null) throw new IllegalArgumentException("file cannot be null.");

		SkeletonData skeletonData = new SkeletonData();

		OrderedMap<String, ?> root = json.fromJson(OrderedMap.class, file);

		// Bones.
		for (OrderedMap boneMap : (Array<OrderedMap>)root.get("bones")) {
			BoneData parent = null;
			String parentName = (String)boneMap.get("parent");
			if (parentName != null) {
				parent = skeletonData.findBone(parentName);
				if (parent == null) throw new SerializationException("Parent bone not found: " + parentName);
			}
			BoneData boneData = new BoneData((String)boneMap.get("name"), parent);
			boneData.length = getFloat(boneMap, "length", 0) * scale;
			boneData.x = getFloat(boneMap, "x", 0) * scale;
			boneData.y = getFloat(boneMap, "y", 0) * scale;
			boneData.rotation = getFloat(boneMap, "rotation", 0);
			boneData.scaleX = getFloat(boneMap, "scaleX", 1);
			boneData.scaleY = getFloat(boneMap, "scaleY", 1);
			skeletonData.addBone(boneData);
		}

		// Slots.
		Array<OrderedMap> slots = (Array<OrderedMap>)root.get("slots");
		if (slots != null) {
			for (OrderedMap slotMap : slots) {
				String slotName = (String)slotMap.get("name");
				String boneName = (String)slotMap.get("bone");
				BoneData boneData = skeletonData.findBone(boneName);
				if (boneData == null) throw new SerializationException("Slot bone not found: " + boneName);
				SlotData slotData = new SlotData(slotName, boneData);

				String color = (String)slotMap.get("color");
				if (color != null) slotData.getColor().set(Color.valueOf(color));

				slotData.setAttachmentName((String)slotMap.get("attachment"));

				skeletonData.addSlot(slotData);
			}
		}

		// Skins.
		OrderedMap<String, OrderedMap> slotMap = (OrderedMap)root.get("skins");
		if (slotMap != null) {
			for (Entry<String, OrderedMap> entry : slotMap.entries()) {
				Skin skin = new Skin(entry.key);
				for (Entry<String, OrderedMap> slotEntry : ((OrderedMap<String, OrderedMap>)entry.value).entries()) {
					int slotIndex = skeletonData.findSlotIndex(slotEntry.key);
					for (Entry<String, OrderedMap> attachmentEntry : ((OrderedMap<String, OrderedMap>)slotEntry.value).entries()) {
						Attachment attachment = readAttachment(attachmentEntry.key, attachmentEntry.value);
						if (attachment != null) skin.addAttachment(slotIndex, attachmentEntry.key, attachment);
					}
				}
				skeletonData.addSkin(skin);
				if (skin.name.equals("default")) skeletonData.setDefaultSkin(skin);
			}
		}

		skeletonData.bones.shrink();
		skeletonData.slots.shrink();
		skeletonData.skins.shrink();
		return skeletonData;
	}

	private Attachment readAttachment (String name, OrderedMap map) {
		name = (String)map.get("name", name);

		AttachmentType type = AttachmentType.valueOf((String)map.get("type", AttachmentType.region.name()));
		Attachment attachment = attachmentLoader.newAttachment(type, name);

		if (attachment instanceof RegionSequenceAttachment) {
			RegionSequenceAttachment regionSequenceAttachment = (RegionSequenceAttachment)attachment;

			Float fps = (Float)map.get("fps");
			if (fps == null) throw new SerializationException("Region sequence attachment missing fps: " + name);
			regionSequenceAttachment.setFrameTime(fps);

			String modeString = (String)map.get("mode");
			regionSequenceAttachment.setMode(modeString == null ? Mode.forward : Mode.valueOf(modeString));
		}

		if (attachment instanceof RegionAttachment) {
			RegionAttachment regionAttachment = (RegionAttachment)attachment;
			regionAttachment.setX(getFloat(map, "x", 0) * scale);
			regionAttachment.setY(getFloat(map, "y", 0) * scale);
			regionAttachment.setScaleX(getFloat(map, "scaleX", 1));
			regionAttachment.setScaleY(getFloat(map, "scaleY", 1));
			regionAttachment.setRotation(getFloat(map, "rotation", 0));
			regionAttachment.setWidth(getFloat(map, "width", 32) * scale);
			regionAttachment.setHeight(getFloat(map, "height", 32) * scale);
			regionAttachment.updateOffset();
		}

		return attachment;
	}

	private float getFloat (OrderedMap map, String name, float defaultValue) {
		Object value = map.get(name);
		if (value == null) return defaultValue;
		return (Float)value;
	}

	public Animation readAnimation (FileHandle file, SkeletonData skeletonData) {
		if (file == null) throw new IllegalArgumentException("file cannot be null.");
		if (skeletonData == null) throw new IllegalArgumentException("skeletonData cannot be null.");

		OrderedMap<String, ?> map = json.fromJson(OrderedMap.class, file);

		Array<Timeline> timelines = new Array();
		float duration = 0;

		OrderedMap<String, ?> bonesMap = (OrderedMap)map.get("bones");
		for (Entry<String, ?> entry : bonesMap.entries()) {
			String boneName = entry.key;
			int boneIndex = skeletonData.findBoneIndex(boneName);
			if (boneIndex == -1) throw new SerializationException("Bone not found: " + boneName);

			OrderedMap<?, ?> timelineMap = (OrderedMap)entry.value;
			for (Entry timelineEntry : timelineMap.entries()) {
				Array<OrderedMap> values = (Array)timelineEntry.value;
				String timelineName = (String)timelineEntry.key;
				if (timelineName.equals(TIMELINE_ROTATE)) {
					RotateTimeline timeline = new RotateTimeline(values.size);
					timeline.setBoneIndex(boneIndex);

					int keyframeIndex = 0;
					for (OrderedMap valueMap : values) {
						float time = (Float)valueMap.get("time");
						timeline.setKeyframe(keyframeIndex, time, (Float)valueMap.get("angle"));
						readCurve(timeline, keyframeIndex, valueMap);
						keyframeIndex++;
					}
					timelines.add(timeline);
					duration = Math.max(duration, timeline.getDuration());

				} else if (timelineName.equals(TIMELINE_TRANSLATE) || timelineName.equals(TIMELINE_SCALE)) {
					TranslateTimeline timeline;
					float timelineScale = 1;
					if (timelineName.equals(TIMELINE_SCALE))
						timeline = new ScaleTimeline(values.size);
					else {
						timeline = new TranslateTimeline(values.size);
						timelineScale = scale;
					}
					timeline.setBoneIndex(boneIndex);

					int keyframeIndex = 0;
					for (OrderedMap valueMap : values) {
						float time = (Float)valueMap.get("time");
						Float x = (Float)valueMap.get("x"), y = (Float)valueMap.get("y");
						timeline.setKeyframe(keyframeIndex, time, x == null ? 0 : (x * timelineScale), y == null ? 0
							: (y * timelineScale));
						readCurve(timeline, keyframeIndex, valueMap);
						keyframeIndex++;
					}
					timelines.add(timeline);
					duration = Math.max(duration, timeline.getDuration());

				} else
					throw new RuntimeException("Invalid timeline type for a bone: " + timelineName + " (" + boneName + ")");
			}
		}

		OrderedMap<String, ?> slotsMap = (OrderedMap)map.get("slots");
		if (slotsMap != null) {
			for (Entry<String, ?> entry : slotsMap.entries()) {
				String slotName = entry.key;
				int slotIndex = skeletonData.findSlotIndex(slotName);
				OrderedMap<?, ?> timelineMap = (OrderedMap)entry.value;

				for (Entry timelineEntry : timelineMap.entries()) {
					Array<OrderedMap> values = (Array)timelineEntry.value;
					String timelineName = (String)timelineEntry.key;
					if (timelineName.equals(TIMELINE_COLOR)) {
						ColorTimeline timeline = new ColorTimeline(values.size);
						timeline.setSlotIndex(slotIndex);

						int keyframeIndex = 0;
						for (OrderedMap valueMap : values) {
							float time = (Float)valueMap.get("time");
							Color color = Color.valueOf((String)valueMap.get("color"));
							timeline.setKeyframe(keyframeIndex, time, color.r, color.g, color.b, color.a);
							readCurve(timeline, keyframeIndex, valueMap);
							keyframeIndex++;
						}
						timelines.add(timeline);
						duration = Math.max(duration, timeline.getDuration());

					} else if (timelineName.equals(TIMELINE_ATTACHMENT)) {
						AttachmentTimeline timeline = new AttachmentTimeline(values.size);
						timeline.setSlotIndex(slotIndex);

						int keyframeIndex = 0;
						for (OrderedMap valueMap : values) {
							float time = (Float)valueMap.get("time");
							timeline.setKeyframe(keyframeIndex++, time, (String)valueMap.get("name"));
						}
						timelines.add(timeline);
						duration = Math.max(duration, timeline.getDuration());

					} else
						throw new RuntimeException("Invalid timeline type for a slot: " + timelineName + " (" + slotName + ")");
				}
			}
		}

		timelines.shrink();
		return new Animation(timelines, duration);
	}

	private void readCurve (CurveTimeline timeline, int keyframeIndex, OrderedMap valueMap) {
		Object curveObject = valueMap.get("curve");
		if (curveObject == null) return;
		if (curveObject.equals("stepped"))
			timeline.setStepped(keyframeIndex);
		else if (curveObject instanceof Array) {
			Array curve = (Array)curveObject;
			timeline.setCurve(keyframeIndex, (Float)curve.get(0), (Float)curve.get(1), (Float)curve.get(2), (Float)curve.get(3));
		}
	}
}
