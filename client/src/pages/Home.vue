<template>
        <div class="main">
            <div class="wrapper">

                <div class="champ item">
                    <h1 class="font">Champions</h1>
                </div>

                <div class="build item">
                    <h1 class="font">Item Build</h1>
                </div>

            </div>
        </div>
</template>

<script>

    export default {
        name: 'Home',
    }

</script>

<style>

.item{
  width: 100%;
  max-width: 350px;
  height: 600px;
  background-color: red;
  margin: 0 100px;
  transition: ease-in-out 0.3s;
  display: flex;
  align-items: flex-end;
  justify-content: center;
}

.champ {
  background-image: url("../assets/katarina.jpg");
  background-position: -160px;
  background-size: cover;
  background-repeat: no-repeat;
}

.build {
  background-image: url("../assets/items.jpg");
  background-position: 62.5%;
  background-size: cover;
  background-repeat: no-repeat;
}

.item:hover {
  transform: scale(1.2);
  transition: ease-in-out 0.3s;
  cursor: pointer;
}

.font {
  color: white;
  font-size: 40px;
}

.item_wrap {
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.wrapper {
  width: 100vw;
  height: 100vh;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
}

.main {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  display: flex; 
  flex-direction: column;
  display: flex;
  justify-content: space-around;
  width: 100vw;
  height: 100vh;
}

</style>