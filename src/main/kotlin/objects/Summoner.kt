package net.guneyilmaz0.riotapi.objects

@Suppress("unused")
data class Summoner(
    val accountId: String,
    val profileIconId: Int,
    val revisionDate: Long,
    val name: String,
    val id: String,
    val puuid: String,
    val summonerLevel: Int
)