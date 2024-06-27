package net.guneyilmaz0.riotapi.objects.champion

@Suppress("unused")
class Champion(
    val id: String,
    val key: String,
    val name: String,
    val title: String,
    val image: Image,
    val skins: List<SkinData>,
    val lore: String,
    val blurb: String,
    val allyTips: List<String>,
    val enemyTips: List<String>,
    val tags: List<String>,
    val partype: String,
    val info: Info,
    val stats: Stats,
    val spells: List<Spell>,
    val passive: Passive,
    val recommended: List<Any>
) {
    class Effect(
        val a: Int,
        val b: Int,
        val c: Int,
        val d: Int,
        val e: Int
    )

    class Image(
        val full: String,
        val sprite: String,
        val group: String,
        val x: Int,
        val y: Int,
        val w: Int,
        val h: Int
    )

    class Info(
        val attack: Int,
        val defense: Int,
        val magic: Int,
        val difficulty: Int
    )

    class LevelTip(
        val label: List<String>,
        val effect: List<String>
    )

    class Passive(
        val name: String,
        val description: String,
        val image: Image
    )

    class Spell(
        val id: String,
        val name: String,
        val description: String,
        val toolTip: String,
        val levelTip: LevelTip,
        val maxRank: Int,
        val coolDown: List<Int>,
        val coolDownBurn: String,
        val cost: List<Int>,
        val costBurn: String,
        val dataValues: List<Any>,
        val effects: List<Effect>,
        val effectBurn: List<String>,
        val vars: List<Any>,
        val costType: String,
        val maxAmmo: String,
        val range: List<Int>,
        val rangeBurn: String,
        val image: Image,
        val resource: String
    )

    data class Stats(
        val hp: Int,
        val hpPerLevel: Int,
        val mp: Int,
        val mpPerLevel: Int,
        val armor: Int,
        val armorPerLevel: Double,
        val spellBlock: Int,
        val spellBlockPerLevel: Double,
        val attackRange: Int,
        val hpRegen: Int,
        val hpRegenPerLevel: Int,
        val mpRegen: Int,
        val mpRegenPerLevel: Int,
        val crit: Int,
        val critPerLevel: Int,
        val attackDamage: Int,
        val attackDamagePerLevel: Int,
        val attackSpeedPerLevel: Double,
        val attackSpeed: Double
    )

    data class SkinData(
        val id: String,
        val num: Int,
        val name: String,
        val chromas: Boolean
    )
}