<template>
<div>
      
    <p class="title">Find out which champion is best suited for you!</p>

    <p class="lane-question">Pick prefered lane: </p>

    <b-dropdown id="dropdown-lane" text="Lane" class="m-md-2">
        <b-dropdown-item v-for="lane in this.lanes" 
                :key="lane" 
                :value="lane"
                @click="handleLaneAnswer(lane)">
                {{lane}}
        </b-dropdown-item>
    </b-dropdown>

    <p class="strength-question">Pick the time when you want your champion to be the strongest: </p>

    <b-dropdown id="dropdown-strength" text="Strength" class="m-md-2">
        <b-dropdown-item v-for="strength in this.strength" 
                :key="strength" 
                :value="strength"
                @click="handleStrengthAnswer(strength)">
                {{strength}}
        </b-dropdown-item>
    </b-dropdown>

    <p class="damage-type-question">Pick the damage type of your champion: </p>

    <b-dropdown id="dropdown-damagetype" text="Damage Type" class="m-md-2">
        <b-dropdown-item v-for="damageType in this.damageType" 
                :key="damageType" 
                :value="damageType"
                @click="handleDamageTypeAnswer(damageType)">
                {{damageType}}
        </b-dropdown-item>
    </b-dropdown>

    <p class="attack-range-question">Pick attack range that your champion has: </p>

    <b-dropdown id="dropdown-attackrange" text="Attack Range" class="m-md-2">
        <b-dropdown-item v-for="attackRange in this.attackRange" 
                :key="attackRange" 
                :value="attackRange"
                @click="handleAttackRangeAnswer(attackRange)">
                {{attackRange}}
        </b-dropdown-item>
    </b-dropdown>

    <p class="ability-resource-question">Pick ability resource of your champion: </p>

    <b-dropdown id="dropdown-abilityresource" text="Ability Resource" class="m-md-2">
        <b-dropdown-item v-for="abilityResource in this.abilityResource" 
                :key="abilityResource" 
                :value="abilityResource"
                @click="handleAbilityResourceAnswer(abilityResource)">
                {{abilityResource}}
        </b-dropdown-item>
    </b-dropdown>

    <p class="playstyle-question">Pick the playstyle that your champion is suited for: </p>

    <b-dropdown id="dropdown-playstyle" text="Playstyle" class="m-md-2">
        <b-dropdown-item v-for="playstyle in this.playstyle" 
                :key="playstyle" 
                :value="playstyle"
                @click="handlePlaystyleAnswer(playstyle)">
                {{playstyle}}
        </b-dropdown-item>
    </b-dropdown>
    
</div>
</template>

<script>

    export default {

        name: 'Champions',

        data: () => ({
            lanes: ['TOP', 'JUNGLE', 'MID', 'BOT', 'SUPPORT'],
            strength: ['EARLY GAME', 'MID GAME', 'LATE GAME'],
            damageType: ['PHYSICAL', 'MAGIC'],
            attackRange: ['MELEE', 'RANGED', 'MIDRANGE'],
            abilityResource: ['MANA', 'ENERGY', 'NOTHING', 'OTHER'],
            playstyle: ['SPLITPUSHING', 'TEAMFIGHTING', 'ROAMING'],


            prefLane: '',
            prefStrength: '',
            prefDamageType: '',
            prefAttackRange: '',
            prefAbilityResource: '',
            prefPlaystyle: ''
        }),

        methods: {

            handleLaneAnswer(lane) {
                this.prefLane = lane
            },

            handleStrengthAnswer(strength) {
                if (strength == "EARLY GAME") this.prefStrength = "EARLY_GAME"
                else if (strength == "MID GAME") this.prefStrength = "MID_GAME"
                else if (strength == "LATE GAME") this.prefStrength = "LATE_GAME"
            },

            handleDamageTypeAnswer(damageType) {
                this.prefDamageType = damageType
            },

            handleAttackRangeAnswer(attackRange) {
                this.prefAttackRange = attackRange
            },

            handleAbilityResourceAnswer(abilityResource) {
                this.prefAbilityResource = abilityResource
            },

            handlePlaystyleAnswer(playstyle) {
                this.playstyle = playstyle
            },

            submit() {
                
            }
        }
    }

</script>


<style>

.title{
  position: absolute;
  background-color: darkslategrey;
  color: white;
  font-size: 35px;
  height: 70px;
  top: 70px;
  margin: 0 50px;
}

.lane-question{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 180px;

    background-color: darkslategrey;
    color: white;
}

.strength-question{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 260px;

    background-color: darkslategrey;
    color: white;
}

.damage-type-question{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 340px;

    background-color: darkslategrey;
    color: white;
}

.attack-range-question{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 420px;

    background-color: darkslategrey;
    color: white;
}

.ability-resource-question{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 500px;

    background-color: darkslategrey;
    color: white;
}

.playstyle-question{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 580px;

    background-color: darkslategrey;
    color: white;
}

#dropdown-lane{
    position:absolute;
    top: 177px;
    width: 150px;
    left: 320px;
}

#dropdown-strength{
    position:absolute;
    top: 257px;
    width: 150px;
    left: 930px;
}

#dropdown-damagetype{
    position:absolute;
    top: 337px;
    width: 150px;
    left: 610px;
}

#dropdown-attackrange{
    position:absolute;
    top: 417px;
    width: 150px;
    left: 630px;
}

#dropdown-abilityresource{
    position:absolute;
    top: 497px;
    width: 150px;
    left: 590px;
}

#dropdown-playstyle{
    position:absolute;
    top: 577px;
    width: 150px;
    left: 740px;
}

</style>