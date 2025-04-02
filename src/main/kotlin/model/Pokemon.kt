package model

class Pokemon {
    val id: Int
    val name: String
    val type1: String
    val type2: String
    var total: Int
    var hp: Int
    var attack: Int
    var defense: Int
    var spcAtack: Int
    var spcDefense: Int
    var speed: Int
    val generation: Int
    val legendary: Boolean

    //constructor per pokemons amb 2 tipus
    constructor(id: Int, name: String, type1: String, type2: String, total: Int, hp: Int, attack: Int, defense: Int, spcAtack: Int, spcDefense: Int, speed: Int, generation: Int, legendary: Boolean) {
        this.id = id
        this.name = name
        this.type1 = type1
        this.type2 = type2
        this.total = total
        this.hp = hp
        this.attack = attack
        this.defense = defense
        this.spcAtack = spcAtack
        this.spcDefense = spcDefense
        this.speed = speed
        this.generation = generation
        this.legendary = legendary
    }

    fun getID():Int{
        return this.id
    }
    fun getnName():String{
        return this.name
    }

    fun getTypeOne():String{
        return this.type1
    }
    fun getTypeTwo():String{
        return this.type2
    }
    fun getTOtal():Int{
        return this.total
    }
    fun gethp():Int{
        return this.hp
    }

    fun getAtack():Int{
        return this.attack
    }
    fun getDefensa():Int{
        return this.defense
    }
    fun getSPcAtack():Int{
        return this.spcAtack
    }
    fun getSpcDEfense():Int{
        return this.spcDefense
    }
    fun getSPeed():Int{
        return  this.speed
    }
    fun getGEneration():Int{
        return this.generation
    }
    fun getLEgendary():Boolean{
        return this.legendary
    }

}