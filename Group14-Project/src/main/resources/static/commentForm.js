function validateForm() {
    var comment = document.getElementById("comment").value;
    if (comment.trim() === "") {
        document.getElementById("commentError").style.display = "block";
        return false; // Prevent form submission
    }
    return true; // Allow form submission
}

document.getElementById('commentForm').addEventListener('submit', function(event) {
    var usernameField = document.getElementById('username');
    var username = "<%= request.getUserPrincipal().getName() %>";
    if (usernameField) {
        usernameField.value = username;
    } else {
        var input = document.createElement('input');
        input.type = 'hidden';
        input.name = 'username';
        input.value = username;
        document.getElementById('commentForm').appendChild(input);
    }
});
