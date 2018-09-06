angular.module('frontendApp')
  .controller('ViewLogController', function ($scope, $interval, $location, loginService, viewLogService) {
    $scope.logs = [];
    
    $scope.shouldDisplayViewLog = function() {
      return loginService.getUser();
    };
    
    $scope.viewReport = function(reportId) {
      $location.path('manageReport/' + reportId);
    };
    var update = function() {
      viewLogService.getLogs()
        .then(function (data) {
          console.log('success');
          $scope.logs = data.logs;
          $scope.data = data;
        }, function () {
          console.log('fail');
        });
    };
    
    update();
    var refresher = $interval(function() {
      if ($scope.shouldDisplayViewLog()) {
        update();
      }
    }, 1000);

    $scope.$on('$destroy', function() {
      $interval.cancel(refresher);
      refresher = null;
    });
  });
