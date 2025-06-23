document.addEventListener('DOMContentLoaded', () => {
    const dashboardTable = document.getElementById('dashboard');
    const completedDashboardTable = document.getElementById('completed_dashboard');
    const courseSortIcon = document.getElementById('course_click');
    const categorySortIcon = document.getElementById('category_click');
    const completedCourseSortIcon = document.getElementById('completed_course_click');
    const completedCategorySortIcon = document.getElementById('completed_category_click');

    let currentlySortedColumnDashboard = 'course';
    let currentlySortedColumnCompletedDashboard = 'course';
    let isAscendingDashboard = true;
    let isAscendingCompletedDashboard = true;

    function updateSortIcon(sortIcon, isAscending) {
        sortIcon.classList.remove('fa-sort', 'fa-sort-up', 'fa-sort-down');
        sortIcon.classList.add(isAscending ? 'fa-sort-down' : 'fa-sort-up');
    }

    function resetSortIcon(sortIcon) {
        sortIcon.classList.remove('fa-sort-up', 'fa-sort-down');
        sortIcon.classList.add('fa-sort');
    }

    function handleSortClick(sortIcon, sortBy, table) {
        let isAscending;
        let currentlySortedColumn;

        if (table === dashboardTable) {
            isAscending = isAscendingDashboard;
            currentlySortedColumn = currentlySortedColumnDashboard;
            currentlySortedColumnDashboard = sortBy;
        } else {
            isAscending = isAscendingCompletedDashboard;
            currentlySortedColumn = currentlySortedColumnCompletedDashboard;
            currentlySortedColumnCompletedDashboard = sortBy;
        }

        if (currentlySortedColumn !== sortBy) isAscending = true;
        else isAscending = !isAscending;

        if (table === dashboardTable) {
            isAscendingDashboard = isAscending;
            resetSortIcon(courseSortIcon);
            resetSortIcon(categorySortIcon);
        } else {
            isAscendingCompletedDashboard = isAscending;
            resetSortIcon(completedCourseSortIcon);
            resetSortIcon(completedCategorySortIcon);
        }

        updateSortIcon(sortIcon, isAscending);

        sortTableRows(sortBy, isAscending, table);
    }

    function sortTableRows(sortBy, isAscending, table) {
        const rows = Array.from(table.querySelectorAll('tbody tr'));
        const sortIcon = table === dashboardTable ? document.getElementById('course_click') : document.getElementById('completed_course_click');
        const colIndex = sortBy === 'course' ? sortIcon.parentElement.cellIndex : sortIcon.parentElement.cellIndex + 1; // Adjusted column index for category

        const sortedRows = rows.sort((a, b) => {
            const valueA = a.cells[colIndex].textContent.trim().toLowerCase();
            const valueB = b.cells[colIndex].textContent.trim().toLowerCase();
            return isAscending ? valueA.localeCompare(valueB) : valueB.localeCompare(valueA);
        });

        const tbody = table.querySelector('tbody');
        tbody.innerHTML = '';
        sortedRows.forEach(row => tbody.appendChild(row));
    }

    courseSortIcon.addEventListener('click', () => handleSortClick(courseSortIcon, 'course', dashboardTable));
    categorySortIcon.addEventListener('click', () => handleSortClick(categorySortIcon, 'category', dashboardTable));
    completedCourseSortIcon.addEventListener('click', () => handleSortClick(completedCourseSortIcon, 'course', completedDashboardTable));
    completedCategorySortIcon.addEventListener('click', () => handleSortClick(completedCategorySortIcon, 'category', completedDashboardTable));

    function showIncomplete() {
        document.getElementById("incomplete").classList.add("active");
        document.getElementById("complete").classList.remove("active");
        document.getElementById("dashboard").classList.remove("hidden");
        document.getElementById("completed_dashboard").classList.add("hidden");
    }

    function showComplete() {
        document.getElementById("complete").classList.add("active");
        document.getElementById("incomplete").classList.remove("active");
        document.getElementById("completed_dashboard").classList.remove("hidden");
        document.getElementById("dashboard").classList.add("hidden");
    }

    document.getElementById("incomplete").addEventListener("click", showIncomplete);
    document.getElementById("complete").addEventListener("click", showComplete);
});
