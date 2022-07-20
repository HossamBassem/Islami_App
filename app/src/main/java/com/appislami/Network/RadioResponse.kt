package com.appislami.Network

data class RadioResponse(
	val radios: List<RadiosItem?>? = null
)

data class RadiosItem(
	val uRL: String? = null,
	val name: String? = null
)

