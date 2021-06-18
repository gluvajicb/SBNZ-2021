<template>
<div>
    <p class="firstPick">Best pick for you: </p>
    <img class="firstpick-image" :src="`http://ddragon.leagueoflegends.com/cdn/11.12.1/img/champion/${firstPick}.png`" alt="champion">
    <b-form-input class="firstResult" v-model="this.firstPick" id="input-1"></b-form-input>

    <p class="secondPick">2nd: </p>
    <img class="secondpick-image" :src="`http://ddragon.leagueoflegends.com/cdn/11.12.1/img/champion/${secondPick}.png`" alt="champion">
    <b-form-input class="secondResult" v-model="this.secondPick" id="input-1"></b-form-input>

    <p class="thirdPick">3rd:</p>
    <img class="thirdpick-image" :src="`http://ddragon.leagueoflegends.com/cdn/11.12.1/img/champion/${thirdPick}.png`" alt="champion">
    <b-form-input class="thirdResult" v-model="this.thirdPick" id="input-1"></b-form-input>

    <b-button @click="back()" class="back" variant="secondary">Go Back</b-button>

</div>

</template>

<script>

export default {

    name: 'Build',

    data() {
        return {
            firstPick: '',
            secondPick: '',
            thirdPick: ''
        }
    },

    methods: {
        back() {
            this.$router.push("/home")
        }
    },

    async created() {
        this.firstPick = localStorage.firstPick;
        this.secondPick = localStorage.secondPick;
        this.thirdPick = localStorage.thirdPick;
    }
}

</script>

<style scoped>

.firstPick{
    position: absolute;
    font-size: 30px;
    margin: 0 260px;
    top: 100px;

    background-color: darkslategrey;
    color: white;
}

.secondPick{
    position: absolute;
    font-size: 30px;
    margin: 0 850px;
    top: 100px;

    background-color: darkslategrey;
    color: white;
}

.thirdPick{
    position: absolute;
    font-size: 30px;
    margin: 0 1400px;
    top: 100px;

    background-color: darkslategrey;
    color: white;
}

.firstpick-image {
    position:absolute;
    top: 185px;
    max-width: 300px;
    width: 150px;
    left: 300px;
}

.secondpick-image {
    position:absolute;
    top: 185px;
    max-width: 300px;
    width: 150px;
    left: 850px;
}

.thirdpick-image {
    position:absolute;
    top: 185px;
    max-width: 300px;
    width: 150px;
    left: 1400px;
}

.firstResult{
    position:absolute;
    top: 385px;
    max-width: 300px;
    width: 150px;
    left: 300px;
}

.secondResult{
    position:absolute;
    top: 385px;
    max-width: 300px;
    width: 150px;
    left: 850px;
}

.thirdResult{
    position:absolute;
    top: 385px;
    max-width: 300px;
    width: 150px;
    left: 1400px;
}

.back{
    position:absolute;
    top: 685px;
    max-width: 300px;
    width: 150px;
    left: 850px;
}

</style>
