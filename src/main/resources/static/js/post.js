
function editPost(id){
    $.ajax({
        type:'GET',
        url: `/api/posts/${id}`,
        success: function (response){
            alert(response)
            let id = post.id;
            let username = post.username;
            let contents = post.contents;
            let modifiedAt = post.modifiedAt;
            let tempHtml = `<th>${id}</th>
                                <th>${username}</th>
                                <th>${title}</th>
                                <th>${contents}</th>
                                <th>${modifiedAt}</th>
                                <th>
                                    <button>수정</button>
                                    <button>삭제</button>
                                </th>`
        }
    })
}

function editPost(id) {
    showEdits(id);
    let contents = $(`#${id}-contents`).text().trim();
    $(`#${id}-textarea`).val(contents);
}

// // 메모를 수정합니다.
// function updatePost(id) {
//     // 1. 작성 대상 메모의 username과 contents 를 확인합니다.
//     let username = $(`#${id}-username`).text().trim();
//     let contents = $(`#${id}-textarea`).val().trim();
//
//     // 2. 작성한 메모가 올바른지 isValidContents 함수를 통해 확인합니다.
//     if (isValidContents(contents) == false) {
//         return;
//     }
//     // 3. 전달할 data JSON으로 만듭니다.
//     let data = {'username': username, 'contents': contents};
//     // 4. PUT /api/memos/{id} 에 data를 전달합니다.
//     $.ajax({
//         type: "PUT",
//         url: `/api/posts/${id}`,
//         contentType: "application/json",
//         data: JSON.stringify(data),
//         success: function (response) {
//             alert('메시지 변경에 성공하였습니다.');
//             window.location.reload();
//         }
//     });
// }
//


function isValidContents(contents) {
    if (contents == '') {
        alert('내용을 입력해주세요');
        return false;
    }
    if (contents.trim().length > 140) {
        alert('공백 포함 140자 이하로 입력해주세요');
        return false;
    }
    return true;
}


$(document).ready(function () {
    getPosts();
})

function getPosts() {
    // 1. 기존 메모 내용을 지웁니다.
    $('#posts-box').empty();

    $.ajax({
        type: 'GET',
        url: '/api/posts',
        success: function (response) {
            for (let i = 0; i < response.length; i++) {
                let post = response[i];
                let id = post.id;
                let username = post.username;
                let title = post.title;
                let contents = post.contents;
                let modifiedAt = post.modifiedAt;

                let tempHtml = `<th>${id}</th>
                                <th id="username">${username}</th>
                                <th id="title">${title}</th>
                                <th id="contents">${contents}</th>
                                <th>${modifiedAt}</th>
                                <th>
                                    <button>수정</button>
                                    <button>삭제</button>
                                </th>`
                $('#posts-box').append(tempHtml);
            }
        }
    })

function writePost() {
    let username = $('#username').val();
    let title = $('#title').val();
    let contents = $('#contents').val();

    if (isValidContents(contents) == false) {
        return;
    }

    let data = {'username': username, 'title': title, 'contents': contents};

    $.ajax({
        type: "POST",
        url: "/api/posts",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (response) {
            alert('메시지가 성공적으로 작성되었습니다.');
            window.location.reload();
        }
    });
}



function deleteOne(id) {
    // 1. DELETE /api/memos/{id} 에 요청해서 메모를 삭제합니다.
    $.ajax({
        type: "DELETE",
        url: `/api/posts/${id}`,
        success: function (response) {
            alert('메시지 삭제에 성공하였습니다.');
            window.location.reload();
        }
    })
}}