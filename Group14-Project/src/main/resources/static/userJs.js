document.addEventListener("DOMContentLoaded", function() {
    const editButton = document.getElementById("editButton");
    const bioForm = document.getElementById("bioInput");
    const alias = document.getElementById("alias");
    const aliasInput = document.getElementById("aliasInput");
    const saveButton = document.getElementById("saveButton");
    const preBio = document.getElementById("preBio");
    const uploadForm = document.getElementById('uploadForm');

    editButton.addEventListener("click", function() {
        bioForm.style.display = "block";
        preBio.style.display = "none";
        uploadForm.style.display = "block";
        alias.style.display = "none";
        aliasInput.style.display = "inline-block";
        saveButton.style.display = "block";
        editButton.style.display = "none";
    });

    saveButton.addEventListener("click", function() {
        bioForm.style.display = "none";
        preBio.style.display = "block";
        uploadForm.style.display = "none";
        alias.style.display = "block";
        aliasInput.style.display = "none";
        saveButton.style.display = "none";
        editButton.style.display = "block";

        const alias2 = document.getElementById('aliasInput').value;
        const bio = document.getElementById('bioInput').value;

        const data = {
            alias: alias2,
            bio: bio
        };

        fetch('/saveProfile', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.ok) {
                    window.location.href = '/user';
                } else {
                    alert("Failed to save changes. Please try again later.");
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });

    uploadForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = new FormData();
        const fileInput = document.getElementById('profileImageFile');

        if (fileInput.files.length > 0) {
            const file = fileInput.files[0];
            formData.append('profileImageFile', file);

            fetch('/uploadProfileImage', {
                method: 'POST',
                body: formData
            })
                .then(response => {
                    if (response.ok) {
                        window.location.href = '/user';
                    } else {
                        alert("Failed to upload image file.");
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        } else {
            alert('Please select an image file.');
        }
    });

});
