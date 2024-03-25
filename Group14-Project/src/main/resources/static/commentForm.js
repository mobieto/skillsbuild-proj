function validateForm() {
    var comment = document.getElementById("comment").value;
    if (comment.trim() === "") {
        document.getElementById("commentError").style.display = "block";
        return false; // Prevent form submission
    }
    return true; // Allow form submission
}