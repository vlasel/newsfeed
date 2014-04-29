Basic instructions

This is the minimal configuration for getting TinyMCE to replace a textarea.

<!-- Place inside the <head> of your HTML -->
<script type="text/javascript" src="<your installation path>/tinymce/tinymce.min.js"></script>
<script type="text/javascript">
tinymce.init({
    selector: "textarea"
 });
</script>

<!-- Place this in the body of the page content -->
<form method="post">
    <textarea></textarea>
</form>