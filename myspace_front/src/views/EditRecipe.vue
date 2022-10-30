<template>
    <ContentBase>
      <div>
        Post a new recipe!
      </div>
      <div id="app">
        <ckeditor :editor="editor" v-model="editorData" :config="editorConfig"></ckeditor>
      </div>
    </ContentBase>
</template>
  
<script>
  import ContentBase from '../components/ContentBase.vue';
  import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

export default {
  name: 'EditRecipe',
    components: {
      ContentBase,
    },
    data() {
        return {
            editor: ClassicEditor,
            editorData: '<h1>Recipe Name</h1><h3>Ingredients</h3><table><tr><th>Ingredients</th><th>Amount</th></tr><tr><td></td><td></td></tr></table><table><tr><th>Steps</th><th>Details</th></tr><tr><td></td><td></td></tr></table>',
            editorConfig: {
                // The configuration of the editor.
            }
        };
    },
}
</script>

<style scoped>
</style>