import net.guneyilmaz0.riotapi.RiotAPI
import net.guneyilmaz0.riotapi.enums.Region
import net.guneyilmaz0.riotapi.enums.Server
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class RiotAPITest {

    @Test
    fun getAccountByNameAndTag() {
        val api = RiotAPI("RGAPI-3ea29c83-c53b-4bce-8d82-995f744be4c0", Region.EUROPE, Server.TR1)
        val account = api.getAccountByNameAndTag("engelli S1ken", "asdas")
        assertEquals("engelli S1ken", account.gameName)
        assertEquals("asdas", account.tagLine)
        println(account.puuid)
    }

    @Test
    fun getMatchesByAccount() {
        val api = RiotAPI("RGAPI-3ea29c83-c53b-4bce-8d82-995f744be4c0", Region.EUROPE, Server.TR1)
        val account = api.getAccountByNameAndTag("engelli S1ken", "asdas")
        val matches = api.getMatchIdsByAccount(account)
        val match = api.getMatchById(matches[0])
        for (participant in match.info.participants) {
            println(participant.championName)
        }
        println(matches)
    }

}