angular.module('frontendApp')
  .controller('ForwardCallController', function ($scope, $interval, $location, loginService, forwardCallService) {
    $scope.operations = [];
    $scope.assignedOperation = null;
    
    $scope.finishOperation = function() {
      forwardCallService.finishOperation($scope.assignedOperation)
        .then(function(data) {
          console.log('success');
          $location.path('/manageReport/' + data.id);
        }, function() {
          console.log('fail');
        });
    };
    
    $scope.shouldDisplayForwardCall = function() {
      return loginService.getUser() && loginService.getUser().type == 'EmergencyUnit';
    };
z
    $scope.fetchOperations = function() {
      forwardCallService.getOperations()
        .then(function(data) {
          console.log('success');
          $scope.operations = data;
          $scope.assignedOperation = forwardCallService.getAssignedOperation($scope.operations);
        }, function() {
          console.log('fail');
        });
    };
    
    $scope.takeOperation = function(op) {
      forwardCallService.takeOperation(op);
    };
    
    var refresher = $interval(function() {
      if ($scope.shouldDisplayForwardCall()) {
        $scope.fetchOperations();
      }
    }, 1000);

    $scope.$on('$destroy', function() {
      $interval.cancel(refresher);
      refresher = null;
    });
  });
