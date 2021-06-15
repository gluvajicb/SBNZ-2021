<template>
<div>
      
        <v-select
          class="test"
          :items="items"
          label="Solo field"
          solo
        ></v-select>

    
</div>
</template>

<script>

    export default {
        name: 'Champions',

        
        data: () => ({
            questions: ['Foo', 'Bar'],
            items: ['Foo', 'Bar', 'Fizz', 'Buzz'],
        })
    }

</script>


<style>

.test{
    max-width: 400px;
    max-height: 300px;
    background-color: red;
}

</style>