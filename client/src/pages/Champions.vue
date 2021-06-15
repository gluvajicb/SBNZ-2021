<template>
<div>

    <v-select
          :items="questions"
          label="Solo field"
          solo
    ></v-select>
    
</div>
</template>

<script>

    export default {
        name: 'Champions',
        
        data: () => ({
            questions: ['Foo', 'Bar']
        })
    }

</script>


<style>

</style>