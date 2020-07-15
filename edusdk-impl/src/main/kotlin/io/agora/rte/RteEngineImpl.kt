package io.agora.rte

import android.content.Context
import android.graphics.Rect
import io.agora.rtc.IRtcEngineEventHandler
import io.agora.rtc.RtcEngine
import io.agora.rtc.models.UserInfo
import io.agora.rtm.RtmClient
import io.agora.rtm.RtmClientListener
import io.agora.rtm.RtmMessage
import io.agora.rtm.RtmStatusCode

internal object RteEngineImpl : IRteEngine {
    lateinit var rtmClient: RtmClient
        private set
    lateinit var rtcEngine: RtcEngine
        private set
    private val channelMap = mutableMapOf<String, IRteChannel>()

    var connectionState = RtmStatusCode.ConnectionState.CONNECTION_STATE_DISCONNECTED

    override fun init(context: Context, appId: String) {
        rtmClient = RtmClient.createInstance(context, appId, rtmClientListener)
        rtcEngine = RtcEngine.create(context, appId, rtcEngineEventHandler)
    }

    override fun createChannel(channelId: String): IRteChannel {
        val rteChannel = RteChannelImpl(channelId)
        channelMap[channelId] = rteChannel
        return rteChannel
    }

    operator fun get(channelId: String): IRteChannel? {
        return channelMap[channelId]
    }

    private val rtmClientListener = object : RtmClientListener {
        override fun onTokenExpired() {
            TODO("Not yet implemented")
        }

        override fun onPeersOnlineStatusChanged(p0: MutableMap<String, Int>?) {
            TODO("Not yet implemented")
        }

        override fun onConnectionStateChanged(p0: Int, p1: Int) {
            TODO("Not yet implemented")
        }

        override fun onMessageReceived(p0: RtmMessage?, p1: String?) {
            TODO("Not yet implemented")
        }
    }

    private val rtcEngineEventHandler = object : IRtcEngineEventHandler() {
        override fun onActiveSpeaker(uid: Int) {
            TODO("Not yet implemented")
        }

        override fun onLocalAudioStats(stats: LocalAudioStats?) {
            TODO("Not yet implemented")
        }

        override fun onRemoteSubscribeFallbackToAudioOnly(uid: Int, isFallbackOrRecover: Boolean) {
            TODO("Not yet implemented")
        }

        override fun onAudioMixingStateChanged(state: Int, errorCode: Int) {
            TODO("Not yet implemented")
        }

        override fun onRtcStats(stats: RtcStats?) {
            TODO("Not yet implemented")
        }

        override fun onFirstRemoteAudioFrame(uid: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onAudioRouteChanged(routing: Int) {
            TODO("Not yet implemented")
        }

        override fun onSubscribeAudioStateChanged(channel: String?, uid: Int, oldstate: Int, newstate: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onLocalVideoStat(sentBitrate: Int, sentFrameRate: Int) {
            TODO("Not yet implemented")
        }

        override fun onAudioQuality(uid: Int, quality: Int, delay: Short, lost: Short) {
            TODO("Not yet implemented")
        }

        override fun onNetworkTypeChanged(type: Int) {
            TODO("Not yet implemented")
        }

        override fun onLocalAudioStateChanged(state: Int, error: Int) {
            TODO("Not yet implemented")
        }

        override fun onFirstRemoteVideoFrame(uid: Int, width: Int, height: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onLastmileQuality(quality: Int) {
            TODO("Not yet implemented")
        }

        override fun onCameraExposureAreaChanged(rect: Rect?) {
            TODO("Not yet implemented")
        }

        override fun onRemoteAudioTransportStats(uid: Int, delay: Int, lost: Int, rxKBitRate: Int) {
            TODO("Not yet implemented")
        }

        override fun onFirstRemoteVideoDecoded(uid: Int, width: Int, height: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onLocalVideoStateChanged(localVideoState: Int, error: Int) {
            TODO("Not yet implemented")
        }

        override fun onTranscodingUpdated() {
            TODO("Not yet implemented")
        }

        override fun onClientRoleChanged(oldRole: Int, newRole: Int) {
            TODO("Not yet implemented")
        }

        override fun onApiCallExecuted(error: Int, api: String?, result: String?) {
            TODO("Not yet implemented")
        }

        override fun onFirstLocalAudioFrame(elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onRemoteAudioStats(stats: RemoteAudioStats?) {
            TODO("Not yet implemented")
        }

        override fun onSubscribeVideoStateChanged(channel: String?, uid: Int, oldstate: Int, newstate: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onRemoteVideoTransportStats(uid: Int, delay: Int, lost: Int, rxKBitRate: Int) {
            TODO("Not yet implemented")
        }

        override fun onStreamUnpublished(url: String?) {
            TODO("Not yet implemented")
        }

        override fun onRejoinChannelSuccess(channel: String?, uid: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onVideoStopped() {
            TODO("Not yet implemented")
        }

        override fun onLocalVideoStats(stats: LocalVideoStats?) {
            TODO("Not yet implemented")
        }

        override fun onStreamMessageError(uid: Int, streamId: Int, error: Int, missed: Int, cached: Int) {
            TODO("Not yet implemented")
        }

        override fun onWarning(warn: Int) {
            TODO("Not yet implemented")
        }

        override fun onLocalPublishFallbackToAudioOnly(isFallbackOrRecover: Boolean) {
            TODO("Not yet implemented")
        }

        override fun onStreamPublished(url: String?, error: Int) {
            TODO("Not yet implemented")
        }

        override fun onMediaEngineStartCallSuccess() {
            TODO("Not yet implemented")
        }

        override fun onStreamInjectedStatus(url: String?, uid: Int, status: Int) {
            TODO("Not yet implemented")
        }

        override fun onUserMuteVideo(uid: Int, muted: Boolean) {
            TODO("Not yet implemented")
        }

        override fun onJoinChannelSuccess(channel: String?, uid: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onLeaveChannel(stats: RtcStats?) {
            TODO("Not yet implemented")
        }

        override fun onMicrophoneEnabled(enabled: Boolean) {
            TODO("Not yet implemented")
        }

        override fun onRemoteVideoStateChanged(uid: Int, state: Int, reason: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onConnectionLost() {
            TODO("Not yet implemented")
        }

        override fun onConnectionBanned() {
            TODO("Not yet implemented")
        }

        override fun onRemoteVideoStats(stats: RemoteVideoStats?) {
            TODO("Not yet implemented")
        }

        override fun onPublishAudioStateChanged(channel: String?, oldstate: Int, newstate: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onFirstLocalVideoFrame(width: Int, height: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onCameraReady() {
            TODO("Not yet implemented")
        }

        override fun onAudioEffectFinished(soundId: Int) {
            TODO("Not yet implemented")
        }

        override fun onStreamMessage(uid: Int, streamId: Int, data: ByteArray?) {
            TODO("Not yet implemented")
        }

        override fun onCameraFocusAreaChanged(rect: Rect?) {
            TODO("Not yet implemented")
        }

        override fun onMediaEngineLoadSuccess() {
            TODO("Not yet implemented")
        }

        override fun onChannelMediaRelayStateChanged(state: Int, code: Int) {
            TODO("Not yet implemented")
        }

        override fun onRequestToken() {
            TODO("Not yet implemented")
        }

        override fun onUserEnableLocalVideo(uid: Int, enabled: Boolean) {
            TODO("Not yet implemented")
        }

        override fun onConnectionInterrupted() {
            TODO("Not yet implemented")
        }

        override fun onRtmpStreamingStateChanged(url: String?, state: Int, errCode: Int) {
            TODO("Not yet implemented")
        }

        override fun onAudioVolumeIndication(speakers: Array<out AudioVolumeInfo>?, totalVolume: Int) {
            TODO("Not yet implemented")
        }

        override fun onAudioMixingFinished() {
            TODO("Not yet implemented")
        }

        override fun onUserJoined(uid: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onTokenPrivilegeWillExpire(token: String?) {
            TODO("Not yet implemented")
        }

        override fun onUserOffline(uid: Int, reason: Int) {
            TODO("Not yet implemented")
        }

        override fun onNetworkQuality(uid: Int, txQuality: Int, rxQuality: Int) {
            TODO("Not yet implemented")
        }

        override fun onRemoteVideoStat(uid: Int, delay: Int, receivedBitrate: Int, receivedFrameRate: Int) {
            TODO("Not yet implemented")
        }

        override fun onVideoSizeChanged(uid: Int, width: Int, height: Int, rotation: Int) {
            TODO("Not yet implemented")
        }

        override fun onLastmileProbeResult(result: LastmileProbeResult?) {
            TODO("Not yet implemented")
        }

        override fun onChannelMediaRelayEvent(code: Int) {
            TODO("Not yet implemented")
        }

        override fun onUserMuteAudio(uid: Int, muted: Boolean) {
            TODO("Not yet implemented")
        }

        override fun onFirstRemoteAudioDecoded(uid: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onLocalUserRegistered(uid: Int, userAccount: String?) {
            TODO("Not yet implemented")
        }

        override fun onError(err: Int) {
            TODO("Not yet implemented")
        }

        override fun onUserEnableVideo(uid: Int, enabled: Boolean) {
            TODO("Not yet implemented")
        }

        override fun onUserInfoUpdated(uid: Int, userInfo: UserInfo?) {
            TODO("Not yet implemented")
        }

        override fun onRemoteAudioStateChanged(uid: Int, state: Int, reason: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }

        override fun onPublishVideoStateChanged(channel: String?, oldstate: Int, newstate: Int, elapsed: Int) {
            TODO("Not yet implemented")
        }
    }
}
