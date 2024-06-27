package net.guneyilmaz0.riotapi.objects.match

@Suppress("unused")
class Match(
    val metadata: Metadata,
    val info: Info
) {
    data class Ban(
        val championId: Int,
        val pickTurn: Int
    )

    data class Info(
        val gameCreation: Long,
        val gameDuration: Long,
        val gameEndTimestamp: Long,
        val gameId: Long,
        val gameMode: String,
        val gameName: String,
        val gameStartTimestamp: Long,
        val gameType: String,
        val gameVersion: String,
        val mapId: Int,
        val participants: List<MatchParticipant>,
        val platformId: String,
        val queueId: Int,
        val teams: List<Team>,
        val tournamentCode: String
    )

    data class Objective(
        val first: Boolean,
        val kills: Int
    )

    data class Objectives(
        val baron: Objective,
        val champion: Objective,
        val dragon: Objective,
        val inhibitor: Objective,
        val riftHerald: Objective,
        val tower: Objective
    )

    data class PerkStats(
        val defense: Int,
        val flex: Int,
        val offense: Int
    )

    data class PerkStyle(
        val description: String,
        val selections: List<PerkStyleSelection>,
        val style: Int
    )

    data class PerkStyleSelection(
        val perk: Int,
        val var1: Int,
        val var2: Int,
        val var3: Int
    )

    data class Perks(
        val statPerks: PerkStats,
        val styles: List<PerkStyle>
    )

    data class Team(
        val bans: List<Ban>,
        val objectives: Objectives,
        val teamId: Int,
        val win: Boolean
    )

    data class Metadata(
        val dataVersion: String,
        val matchId: String,
        val participants: List<String>
    )
}