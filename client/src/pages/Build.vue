<template>
    <div>

        <p class="title">Find out which item build is the best for your current game!</p>
        
        <!-- Lane -->

        <p class="lane">Pick the lane that you are playing on: </p>

        <b-dropdown id="dropdown-lane" text="Lane" class="m-md-2">
            <b-dropdown-item v-for="lane in this.lanes" 
                    :key="lane" 
                    :value="lane"
                    @click="handleLane(lane)">
                    {{lane}}
            </b-dropdown-item>
        </b-dropdown>

        <b-form-input class="outputLane" v-model="this.pickedLane"></b-form-input>

        <!-- Picked champion -->

        <p class="picked-champion">Enter the champion name that you are playing: </p>

        <b-form-input class="picked-champion-input" v-model="pickedChampion"></b-form-input>

        <!-- Playing against -->

        <p class="enemy">Enter champion name that you are playing against: </p>

        <b-form-input class="enemy-champion-input" v-model="enemyChampionName"></b-form-input>

        <!-- 4 Other Champions -->

        <p class="enemies">Enter 4 other champions that are playing against you on other lanes: </p>

        <b-form-input class="firstEnemy" v-model="firstEnemy"></b-form-input>

        <b-form-input class="secondEnemy" v-model="secondEnemy"></b-form-input>

        <b-form-input class="thirdEnemy" v-model="thirdEnemy"></b-form-input>

        <b-form-input class="fourthEnemy" v-model="fourthEnemy"></b-form-input>

        <!-- Early Game Playstyle -->

        <p class="early-playstyle">How do you plan on playing an early game: </p>

        <b-dropdown id="dropdown-early-playstyle" text="Playstyle" class="m-md-2">
            <b-dropdown-item v-for="earlyPlaystyle in this.playstyles" 
                    :key="earlyPlaystyle" 
                    :value="earlyPlaystyle"
                    @click="handlePlaystyle(earlyPlaystyle)">
                    {{earlyPlaystyle}}
            </b-dropdown-item>
        </b-dropdown>

        <b-form-input class="output-early-playstyle" v-model="this.earlyGamePlaystyle"></b-form-input>

        <b-button @click="submit()" class="submit" variant="success">Submit Answers</b-button>

        <b-button @click="cancel()" class="cancel" variant="secondary">Cancel</b-button>

    </div>
</template>

<script>

// import {AXIOS} from '../http-common'

export default {

    name: 'Build',

    data() {
        return {
            lanes: ['TOP', 'JUNGLE', 'MID', 'BOT', 'SUPPORT'],
            playstyles: ['OFFENSIVE', 'DEFENSIVE', 'SUSTAIN', 'SUPPORT'],
    
            pickedLane: '',
            enemyChampionName: '',
            pickedChampion: '',
            enemyChampionList: '',
            earlyGamePlaystyle: '',
    
            firstEnemy: '',
            secondEnemy: '',
            thirdEnemy: '',
            fourthEnemy: '',
        }
    },

    methods: {
        handleLane(lane) {
            this.pickedLane = lane
        },

        handlePlaystyle(playstyle) {
            this.earlyGamePlaystyle = playstyle
        },

        submit() {
            // var buildAnswers = {
            //     pickedLane: this.pickedLane,
            //     pickedChampion: this.pickedChampion,
            //     enemyChampionName: this.enemyChampionName,
            //     enemyChampionList: this.firstEnemy + "," + this.secondEnemy + "," + this.thirdEnemy + "," + this.fourthEnemy,
            //     earlyGamePlaystyle: this.earlyGamePlaystyle
            // }

            // AXIOS.post('/build-recommender', buildAnswers)
            //     .then(response => {console.log(response.data)})

            // var startingItem = response.data.startingItem;
            // var boots = response.data.boots;
            // var situationalItem = response.data.situationalItem;
            // var defensiveItem = response.data.defensiveItem;
            // var offensiveItem = response.data.offensiveItem;
            // var mythicItem = response.data.mythicItem;

            // localStorage.setItem('startingItem', startingItem)
            // localStorage.setItem('boots', boots)
            // localStorage.setItem('situationalItem', situationalItem)
            // localStorage.setItem('defensiveItem', defensiveItem)
            // localStorage.setItem('offensiveItem', offensiveItem)
            // localStorage.setItem('mythicItem', mythicItem)

            localStorage.setItem('startingItem', "Abyssal_Mask")
            localStorage.setItem('boots', "Archangels_Staff")
            localStorage.setItem('situationalItem', "Banshees_Veil")
            localStorage.setItem('defensiveItem', "Berserker_Greaves")
            localStorage.setItem('offensiveItem', "Black_Cleaver")
            localStorage.setItem('mythicItem', "Thornmail")

            this.$router.push('/build-results')
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
  height: 70px;
  top: 70px;
  margin: 0 50px;
}

.lane{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 180px;

    background-color: darkslategrey;
    color: white;
}

.picked-champion{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 250px;

    background-color: darkslategrey;
    color: white;
}

.enemy{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 320px;

    background-color: darkslategrey;
    color: white;
}

.enemies{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 390px;

    background-color: darkslategrey;
    color: white;
}

.early-playstyle{
    position: absolute;
    font-size: 30px;
    margin: 0 50px;
    top: 460px;

    background-color: darkslategrey;
    color: white;
}

.firstEnemy{
    position:absolute;
    top: 395px;
    max-width: 220px;
    width: 150px;
    left: 970px;
}

.secondEnemy{
    position:absolute;
    top: 395px;
    max-width: 220px;
    width: 150px;
    left: 1150px;
}

.thirdEnemy{
    position:absolute;
    top: 395px;
    max-width: 220px;
    width: 150px;
    left: 1330px;
}

.fourthEnemy{
    position:absolute;
    top: 395px;
    max-width: 220px;
    width: 150px;
    left: 1510px;
}

#dropdown-lane{
    position:absolute;
    top: 177px;
    width: 150px;
    left: 560px;
}

#dropdown-early-playstyle{
    position:absolute;
    top: 455px;
    width: 150px;
    left: 650px;
}

.outputLane{
    position:absolute;
    top: 185px;
    max-width: 220px;
    width: 150px;
    left: 740px;
}

.output-early-playstyle{
    position:absolute;
    top: 460px;
    max-width: 220px;
    width: 150px;
    left: 840px;
}

.enemy-champion-input{
    position:absolute;
    top: 320px;
    max-width: 220px;
    width: 150px;
    left: 750px;
}

.picked-champion-input{
    position:absolute;
    top: 250px;
    max-width: 220px;
    width: 150px;
    left: 700px;
}

.submit{
    position:absolute;
    top: 550px;
    width: 150px;
    left: 50px;
}

.cancel{
    position:absolute;
    top: 550px;
    width: 150px;
    left: 250px;
}
</style>
