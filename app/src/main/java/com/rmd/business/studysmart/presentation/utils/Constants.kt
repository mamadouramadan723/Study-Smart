package com.rmd.business.studysmart.presentation.utils

object Constants {

    const val ACTION_SERVICE_START = "ACTION_SERVICE_START"
    const val ACTION_SERVICE_STOP = "ACTION_SERVICE_STOP"
    const val ACTION_SERVICE_CANCEL = "ACTION_SERVICE_CANCEL"

    const val NOTIFICATION_CHANNEL_ID = "TIMER_NOTIFICATION_ID"
    const val NOTIFICATION_CHANNEL_NAME = "TIMER_NOTIFICATION"
    const val NOTIFICATION_ID = 10

    const val CLICK_REQUEST_CODE = 100
}

enum class TimerState {
    IDLE,
    STARTED,
    STOPPED
}