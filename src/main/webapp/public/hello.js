function Hello($scope, $http) {
    $http.get('http://127.0.0.1:8080/web/greeting').
        success(function(data) {
            $scope.greeting = data;
        });
}