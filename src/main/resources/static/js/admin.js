const usersTable = document.getElementById("users-table-content");
const button = document.getElementById("fetch-users-button");
// const path = window.location.pathname;
//
// const chatId = path.split("/")[1];
function myFunction(){
    button.addEventListener("click",() => {
        fetchUsers().then((data) => renderUsersTable(data)).catch((error) => console.log(error))
    })
}
// button.addEventListener("click",() => {
//     fetchUsers().then((data) => renderUsersTable(data)).catch((error) => console.log(error))
// })

function fetchUsers() {
    return fetch("http://localhost:8080/admin/users/545081236").then((response) => {
        if (!response.ok) {
            throw new Error(response.statusText);
        }
        return response.json();
    })
}

function renderUsersTable(users) {
    const markup = users.map((user) => {
        return `<tr>
            <th scope="row">${user.id}</th>
            <td>${user.chatId}</td>
            <td>${user.admin}</td>
            <td>${user.name}</td>
            <td>${user.phone}</td> </tr>`
    }).join("");
    usersTable.innerHTML = markup;
}