const users = document.getElementById("users-table");
const path = window.location.pathname;

const chatId = path.split("/")[1];
document.addEventListener("DOMContentLoaded", () => {
    fetchUsers().then((data) => renderUsersTable(data)).catch((error) => console.log(error))
})

function fetchUsers() {
    return fetch("/admin/" + chatId + "/users").then((response) => {
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
            <td>${user.phone}</td> `
    }).join("");
    users.innerHTML = markup;
}