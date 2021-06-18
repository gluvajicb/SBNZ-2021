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

    <b-form-input class="outputClass" v-model="this.prefClass" id="input-1"></b-form-input>

   <p class="class-question">Pick prefered class: </p>

    <b-dropdown id="dropdown-class" text="Class" class="m-md-2">
        <b-dropdown-item v-for="prefClass in this.classes" 
                :key="prefClass" 
                :value="prefClass"
                @click="handleClassAnswer(prefClass)">
                {{prefClass}}
        </b-dropdown-item>
    </b-dropdown>

    <b-form-input class="outputLane" v-model="this.prefLane" id="input-1"></b-form-input>

    <p class="strength-question">Pick the time when you want your champion to be the strongest: </p>

    <b-dropdown id="dropdown-strength" text="Strength" class="m-md-2">
        <b-dropdown-item v-for="strength in this.strength" 
                :key="strength" 
                :value="strength"
                @click="handleStrengthAnswer(strength)">
                {{strength}}
        </b-dropdown-item>
    </b-dropdown>

    <b-form-input class="outputStrength" v-model="this.prefStrength" id="input-1"></b-form-input>

    <p class="damage-type-question">Pick the damage type of your champion: </p>

    <b-dropdown id="dropdown-damagetype" text="Damage Type" class="m-md-2">
        <b-dropdown-item v-for="damageType in this.damageType" 
                :key="damageType" 
                :value="damageType"
                @click="handleDamageTypeAnswer(damageType)">
                {{damageType}}
        </b-dropdown-item>
    </b-dropdown>

    <b-form-input class="outputDamage" v-model="this.prefDamageType" id="input-1"></b-form-input>

    <p class="attack-range-question">Pick attack range that your champion has: </p>

    <b-dropdown id="dropdown-attackrange" text="Attack Range" class="m-md-2">
        <b-dropdown-item v-for="attackRange in this.attackRange" 
                :key="attackRange" 
                :value="attackRange"
                @click="handleAttackRangeAnswer(attackRange)">
                {{attackRange}}
        </b-dropdown-item>
    </b-dropdown>

    <b-form-input class="outputRange" v-model="this.prefAttackRange" id="input-1"></b-form-input>

    <p class="ability-resource-question">Pick ability resource of your champion: </p>

    <b-dropdown id="dropdown-abilityresource" text="Ability Resource" class="m-md-2">
        <b-dropdown-item v-for="abilityResource in this.abilityResource" 
                :key="abilityResource" 
                :value="abilityResource"
                @click="handleAbilityResourceAnswer(abilityResource)">
                {{abilityResource}}
        </b-dropdown-item>
    </b-dropdown>

    <b-form-input class="outputResource" v-model="this.prefAbilityResource" id="input-1"></b-form-input>

    <p class="playstyle-question">Pick the playstyle that your champion is suited for: </p>

    <b-dropdown id="dropdown-playstyle" text="Playstyle" class="m-md-2">
        <b-dropdown-item v-for="playstyle in this.playstyle" 
                :key="playstyle" 
                :value="playstyle"
                @click="handlePlaystyleAnswer(playstyle)">
                {{playstyle}}
        </b-dropdown-item>
    </b-dropdown>

    <b-form-input class="outputPlaystyle" v-model="this.prefPlaystyle" id="input-1"></b-form-input>

    <b-button @click="submit()" class="submit" variant="success">Submit Answers</b-button>

    <b-button @click="cancel()" class="cancel" variant="secondary">Cancel</b-button>
    
</div>
</template>

<script>

    // import {AXIOS} from '../http-common'

    export default {

        name: 'Champions',

        data: () => ({
            lanes: ['TOP', 'JUNGLE', 'MID', 'BOT', 'SUPPORT'],
            strength: ['EARLY GAME', 'MID GAME', 'LATE GAME'],
            damageType: ['PHYSICAL', 'MAGIC'],
            attackRange: ['MELEE', 'RANGED', 'MIDRANGE'],
            abilityResource: ['MANA', 'ENERGY', 'NOTHING', 'OTHER'],
            playstyle: ['SPLITPUSHING', 'TEAMFIGHTING', 'ROAMING'],
            classes: ['BRUISER', 'MARKSMAN', 'MAGE', 'ASSASSIN', 'SUPPORT', 'TANK'],

            prefLane: '',
            prefClass: '',
            prefStrength: '',
            prefDamageType: '',
            prefAttackRange: '',
            prefAbilityResource: '',
            prefPlaystyle: '',

            recommendedChampions: []
        }),

        methods: {

            handleLaneAnswer(lane) {
                this.prefLane = lane
            },

            handleClassAnswer(prefClass) {
                this.prefClass = prefClass
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
                this.prefPlaystyle = playstyle
            },

            submit() {
                // var championAnswers = {
                //     prefLane: this.prefLane,
                //     prefClass: this.prefClass,
                //     prefStrength: this.prefStrength,
                //     prefDamageType: this.prefDamageType,
                //     prefAttackRange: this.prefAttackRange,
                //     prefAbilityResource: this.prefAbilityResource,
                //     prefPlaystyle: this.prefPlaystyle
                // }

                // AXIOS.post('/champion-recommender', championAnswers)
                //     .then(response => {console.log(response.data)})


                // var firstPick = response.data.firstPick;
                // var secondPick = response.data.secondPick;
                // var thirdPick = response.data.thirdpick;

                // localStorage.setItem('firstPick', firstPick)
                // localStorage.setItem('secondPick', secondPick)
                // localStorage.setItem('thirdPick', thirdPick)

                // Ovo su mock podaci ispod, samo otkomentarisi ovo iznad i to bi trebalo da radi live sa backom
                localStorage.setItem('firstPick', "Jinx")
                localStorage.setItem('secondPick', "Karthus")
                localStorage.setItem('thirdPick', "Maokai")

                this.$router.push("/champion-results")
            },

            cancel() {
                this.$router.push("/home")
            }
        }
    }

</script>


<style scoped>

.title{
  position: absolute;
  background-color: darkslategrey;
  color: white;
  font-size: 35px;
  height: 55px;
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

.class-question{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 260px;

    background-color: darkslategrey;
    color: white;
}

.strength-question{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 340px;

    background-color: darkslategrey;
    color: white;
}

.damage-type-question{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 420px;

    background-color: darkslategrey;
    color: white;
}

.attack-range-question{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 500px;

    background-color: darkslategrey;
    color: white;
}

.ability-resource-question{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 580px;

    background-color: darkslategrey;
    color: white;
}

.playstyle-question{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 660px;

    background-color: darkslategrey;
    color: white;
}

#dropdown-lane{
    position:absolute;
    top: 177px;
    width: 150px;
    left: 320px;
}

#dropdown-class{
    position:absolute;
    top: 257px;
    width: 150px;
    left: 320px;
}

#dropdown-strength{
    position:absolute;
    top: 337px;
    width: 150px;
    left: 930px;
}

#dropdown-damagetype{
    position:absolute;
    top: 417px;
    width: 150px;
    left: 610px;
}

#dropdown-attackrange{
    position:absolute;
    top: 497px;
    width: 150px;
    left: 630px;
}

#dropdown-abilityresource{
    position:absolute;
    top: 577px;
    width: 150px;
    left: 590px;
}

#dropdown-playstyle{
    position:absolute;
    top: 657px;
    width: 150px;
    left: 740px;
}

.submit{
    position:absolute;
    top: 760px;
    width: 150px;
    left: 50px;
}

.cancel{
    position:absolute;
    top: 760px;
    width: 150px;
    left: 250px;
}

.outputLane{
    position:absolute;
    top: 185px;
    max-width: 100px;
    width: 150px;
    left: 500px;
}

.outputClass{
    position:absolute;
    top: 265px;
    max-width: 120px;
    width: 150px;
    left: 500px;
}

.outputStrength{
    position:absolute;
    top: 345px;
    max-width: 135px;
    width: 150px;
    left: 1120px;
}

.outputDamage{
    position:absolute;
    top: 425px;
    max-width: 105px;
    width: 150px;
    left: 800px;
}

.outputRange{
    position:absolute;
    top: 505px;
    max-width: 115px;
    width: 150px;
    left: 810px;
}

.outputResource{
    position:absolute;
    top: 585px;
    max-width: 100px;
    width: 150px;
    left: 770px;
}

.outputPlaystyle{
    position:absolute;
    top: 665px;
    max-width: 150px;
    width: 150px;
    left: 910px;
}

</style>