package net.swade.riot.api;

import lombok.Getter;

import java.util.Objects;

public enum Server {
    BR1("br1", "Brazil"),
    EUN1("eun1", "Europe Nordic & East"),
    EUW1("euw1", "Europe West"),
    JP1("jp1", "Japan"),
    KR("kr", "Republic of Korea"),
    LA1("la1", "Latin America North"),
    LA2("la2", "Latin America South"),
    NA1("na1", "North America"),
    OC1("oc1", "Oceania"),
    PH2("ph2", "The Philippines"),
    RU("ru", "Russia"),
    SG2("sg2", "Singapore, Malaysia, & Indonesia"),
    TH2("th2", "Thailand"),
    TR1("tr1", "Turkey"),
    TW2("tw2", "Taiwan, Hong Kong, and Macao"),
    VN2("vn2", "Vietnam"),
    NULL("null", "null");

    @Getter private final String serverCode;
    @Getter private final String name;

    Server(String serverCode, String name) {
        this.serverCode = serverCode;
        this.name = name;
    }

    public static Server getByServerCode(String serverCode) {
        for (Server server : values()) {
            if (Objects.equals(server.getServerCode(), serverCode)) {
                return server;
            }
        }
        return NULL;
    }
}
