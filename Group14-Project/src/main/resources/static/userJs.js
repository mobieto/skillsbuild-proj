document.addEventListener("DOMContentLoaded", function() {
    const editButton = document.getElementById("editButton");
    const bioForm = document.getElementById("bioInput");
    const alias = document.getElementById("alias");
    const aliasInput = document.getElementById("aliasInput");
    const saveButton = document.getElementById("saveButton");
    const preBio = document.getElementById("preBio");
    const profileImageFile = document.getElementById("profileImageFile");
    let imageUploaded = false;

    editButton.addEventListener("click", function() {
        bioForm.style.display = "block";
        preBio.style.display = "none";
        alias.style.display = "none";
        aliasInput.style.display = "inline-block";
        saveButton.style.display = "block";
        editButton.style.display = "none";
        profileImageFile.style.display = "inline-block";
    });

    saveButton.addEventListener("click", function() {
        const alias2 = document.getElementById('aliasInput').value;
        const bio = document.getElementById('bioInput').value;

        const data = {
            alias: alias2,
            bio: bio
        };

        if (imageUploaded) {
            const file = profileImageFile.files[0];
            const formData = new FormData();
            formData.append('profileImageFile', file);

            fetch('/uploadProfileImage', {
                method: 'POST',
                body: formData
            })
                .then(response => {
                    if (response.ok) {
                        saveProfile(data);
                    } else {
                        alert("Failed to upload image file. Make sure image is MAX: 1MB");
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        } else {
            saveProfile(data);
        }
    });

    profileImageFile.addEventListener('change', function(event) {
        imageUploaded = true;
    });

    function saveProfile(data) {
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
    }
});
