angular.module('frontendApp')
  .factory('acceptCallService', function($http, $q, serviceURL, loginService) {
    return {
      createLog: function() {
        return $q(function(resolve, reject) {
          $http({
            method: 'POST',
            url: serviceURL + '/manageLog'
          }).then(function(response) {
            // success
            var data = response.data;
            if (data.success) {
              resolve(data);
            } else {
              reject();
            }
            resolve(response.data);
          }, function(response) {
            // failure
            reject();
          });
        });
      },
      acceptCall: function(data) {
        data['dispatcherId'] = loginService.getUser().id;
        return $q(function(resolve, reject) {
          $http({
            method: 'POST',
            url: serviceURL + '/acceptCall',
            data: data
          }).then(function(response) {
            // success
            var data = response.data;
            if (data.success) {
              resolve();
            } else {
              reject();
            }
            resolve(response.data);
          }, function(response) {+
            // failure
            reject();
          });
        });
      }
    };
  });