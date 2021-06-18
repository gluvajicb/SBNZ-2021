<template>
<div>
    <!-- Starting Item -->
    <p class="starting-item">Starting Item</p>
    <img class="starting-item-image" :src="require(`@/assets/items/${startingItem}.png`)" alt="item">
    <b-form-input disabled class="starting-item-result" v-model="this.startingItemReplaced" id="input-1"></b-form-input>

    <!-- Boots -->
    <p class="boots">Boots</p>
    <img class="boots-image" :src="require(`@/assets/items/${boots}.png`)" alt="item">
    <b-form-input disabled class="boots-result" v-model="this.bootsReplaced" id="input-1"></b-form-input>

    <!-- Mythic Item -->
    <p class="mythic-item">Mythic</p>
    <img class="mythic-item-image" :src="require(`@/assets/items/${mythicItem}.png`)" alt="item">
    <b-form-input disabled class="mythic-item-result" v-model="this.mythicItemReplaced" id="input-1"></b-form-input>

    <!-- Situational Item -->
    <p class="situational-item">Situational</p>
    <img class="situational-item-image" :src="require(`@/assets/items/${situationalItem}.png`)" alt="item">
    <b-form-input disabled class="situational-item-result" v-model="this.situationalItemReplaced" id="input-1"></b-form-input>

    <!-- Offensive Item -->
    <p class="offensive-item">Offensive</p>
    <img class="offensive-item-image" :src="require(`@/assets/items/${offensiveItem}.png`)" alt="item">
    <b-form-input disabled class="offensive-item-result" v-model="this.offensiveItemReplaced" id="input-1"></b-form-input>

    <!-- Defensive Item -->
    <p class="defensive-item">Defensive</p>
    <img class="defensive-item-image" :src="require(`@/assets/items/${defensiveItem}.png`)" alt="item">
    <b-form-input disabled class="defensive-item-result" v-model="this.defensiveItemReplaced" id="input-1"></b-form-input>



    <b-button @click="back()" class="back" variant="secondary">Go Back</b-button>
</div>
</template>

<script>

export default {

    name: 'Build',

    data() {
        return {
            startingItem: '',
            boots: '',
            situationalItem: '',
            defensiveItem: '',
            offensiveItem: '',
            mythicItem: '',

            startingItemReplaced: '',
            bootsReplaced: '',
            situationalItemReplaced: '',
            defensiveItemReplaced: '',
            offensiveItemReplaced: '',
            mythicItemReplaced: '',

        }
    },

    methods: {
        back() {
            this.$router.push("/home")
        },

        replaceName() {
            this.startingItemReplaced = this.startingItem.replaceAll("_", " ")
            this.bootsReplaced = this.boots.replaceAll("_", " ")
            this.situationalItemReplaced = this.situationalItem.replaceAll("_", " ")
            this.offensiveItemReplaced = this.offensiveItem.replaceAll("_", " ")
            this.defensiveItemReplaced = this.defensiveItem.replaceAll("_", " ")
            this.mythicItemReplaced = this.mythicItem.replaceAll("_", " ")
        }


    },

    async created() {
        this.startingItem = localStorage.startingItem;
        this.boots = localStorage.boots;
        this.situationalItem = localStorage.situationalItem;
        this.offensiveItem = localStorage.offensiveItem;
        this.defensiveItem = localStorage.defensiveItem;
        this.mythicItem = localStorage.mythicItem;

        this.replaceName()
    }
}

</script>

<style scoped>

.starting-item{
    position: absolute;
    font-size: 30px;
    margin: 0 290px;
    top: 60px;

    background-color: darkslategrey;
    color: white;
}

.starting-item-image {
    position:absolute;
    top: 135px;
    max-width: 300px;
    width: 150px;
    left: 300px;
}

.starting-item-result{
    position:absolute;
    top: 315px;
    max-width: 300px;
    width: 250px;
    left: 265px;
}

.boots{
    position: absolute;
    font-size: 30px;
    margin: 0 800px;
    top: 60px;

    background-color: darkslategrey;
    color: white;
}

.boots-image {
    position:absolute;
    top: 135px;
    max-width: 300px;
    width: 150px;
    left: 800px;
}

.boots-result{
    position:absolute;
    top: 315px;
    max-width: 300px;
    width: 250px;
    left: 765px;
}

.mythic-item{
    position: absolute;
    font-size: 30px;
    margin: 0 1300px;
    top: 60px;

    background-color: darkslategrey;
    color: white;
}

.mythic-item-image {
    position:absolute;
    top: 135px;
    max-width: 300px;
    width: 150px;
    left: 1300px;
}

.mythic-item-result{
    position:absolute;
    top: 315px;
    max-width: 300px;
    width: 250px;
    left: 1265px;
}

.offensive-item{
    position: absolute;
    font-size: 30px;
    margin: 0 300px;
    top: 420px;

    background-color: darkslategrey;
    color: white;
}

.offensive-item-image {
    position:absolute;
    top: 500px;
    max-width: 300px;
    width: 150px;
    left: 300px;
}

.offensive-item-result{
    position:absolute;
    top: 690px;
    max-width: 300px;
    width: 250px;
    left: 245px;
}

.defensive-item{
    position: absolute;
    font-size: 30px;
    margin: 0 800px;
    top: 420px;

    background-color: darkslategrey;
    color: white;
}

.defensive-item-image {
    position:absolute;
    top: 500px;
    max-width: 300px;
    width: 150px;
    left: 800px;
}

.defensive-item-result{
    position:absolute;
    top: 690px;
    max-width: 300px;
    width: 250px;
    left: 765px;
}

.situational-item{
    position: absolute;
    font-size: 30px;
    margin: 0 1300px;
    top: 420px;

    background-color: darkslategrey;
    color: white;
}

.situational-item-image {
    position:absolute;
    top: 500px;
    max-width: 300px;
    width: 150px;
    left: 1300px;
}

.situational-item-result{
    position:absolute;
    top: 690px;
    max-width: 300px;
    width: 250px;
    left: 1265px;
}

.back{
    position:absolute;
    top: 850px;
    max-width: 300px;
    width: 150px;
    left: 800px;
}

</style>
