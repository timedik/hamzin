<?php

header('Content-Type: application/json; charset=utf-8');

$uri = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);

if ($uri === '/header-auth') {

    $auth = $_SERVER['HTTP_AUTHORIZATION'] ?? '';

    if ($auth === 'secret123') {
        echo json_encode([
            'message' => 'Авторизация успешна'
        ], JSON_UNESCAPED_UNICODE);
    } else {
        echo json_encode([
            'message' => 'Ошибка авторизации'
        ], JSON_UNESCAPED_UNICODE);
    }

} elseif ($uri === '/param-auth') {

    $token = $_GET['token'] ?? '';

    if ($token === '12345') {
        echo json_encode([
            'message' => 'Авторизация успешна'
        ], JSON_UNESCAPED_UNICODE);
    } else {
        echo json_encode([
            'message' => 'Ошибка авторизации'
        ], JSON_UNESCAPED_UNICODE);
    }

} else {

    echo json_encode([
        'message' => 'Маршрут не найден'
    ], JSON_UNESCAPED_UNICODE);

}

# GET http://localhost:8000/header-auth