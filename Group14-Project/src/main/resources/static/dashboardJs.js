document.addEventListener('DOMContentLoaded', () => {
    const table = document.getElementById('dashboard');
    const courseSortIcon = document.getElementById('course_click');
    const categorySortIcon = document.getElementById('category_click');

    let currentlySortedColumn = 'course';
    let isAscending = true;

    function updateSortIcon(sortIcon, isAscending) {
        sortIcon.classList.remove('fa-sort', 'fa-sort-up', 'fa-sort-down');
        sortIcon.classList.add(isAscending ? 'fa-sort-down' : 'fa-sort-up');
    }

    function resetSortIcon(sortIcon) {
        sortIcon.classList.remove('fa-sort-up', 'fa-sort-down');
        sortIcon.classList.add('fa-sort');
    }

    function handleSortClick(sortIcon, sortBy) {
        if (currentlySortedColumn !== sortBy) isAscending = true;
        else isAscending = !isAscending;

        currentlySortedColumn = sortBy;

        resetSortIcon(courseSortIcon);
        resetSortIcon(categorySortIcon);
        updateSortIcon(sortIcon, isAscending);

        sortTableRows(sortBy);
    }

    function sortTableRows(sortBy) {
        const rows = Array.from(table.querySelectorAll('tbody tr'));
        const colIndex = sortBy === 'course' ? courseSortIcon.parentElement.cellIndex : categorySortIcon.parentElement.cellIndex;

        const sortedRows = rows.sort((a, b) => {
            const valueA = a.cells[colIndex].textContent.trim().toLowerCase();
            const valueB = b.cells[colIndex].textContent.trim().toLowerCase();
            return isAscending ? valueA.localeCompare(valueB) : valueB.localeCompare(valueA);
        });

        const tbody = table.querySelector('tbody');
        tbody.innerHTML = '';
        sortedRows.forEach(row => tbody.appendChild(row));
    }

    courseSortIcon.addEventListener('click', () => handleSortClick(courseSortIcon, 'course'));
    categorySortIcon.addEventListener('click', () => handleSortClick(categorySortIcon, 'category'));
});
