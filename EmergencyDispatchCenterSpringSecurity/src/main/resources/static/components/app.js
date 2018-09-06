'use strict';

/**
 * @ngdoc overview
 * @name frontendApp
 * @description
 * # frontendApp
 *
 * Main module of the application.
 */
angular
  .module('frontendApp', ['angular-loading-bar', 'angular-sha1', 'ngRoute'])
  .constant('serviceURL', 'http://localhost:8080')
  .config(function($httpProvider, $routeProvider, cfpLoadingBarProvider) {
    $httpProvider.defaults.withCredentials = true;
    cfpLoadingBarProvider.includeSpinner = false;
    cfpLoadingBarProvider.includeBar = true;
    
    $routeProvider.
      when('/login', {
        templateUrl: 'components/login/login.html',
        controller: 'loginController'
      }).
      when('/acceptCall', {
        templateUrl: 'components/acceptCall/acceptCall.html',
        controller: 'AcceptCallController'
      }).
      when('/forwardCall', {
        templateUrl: 'components/forwardCall/forwardCall.html',
        controller: 'ForwardCallController'
      }).
      when('/manageReport', {
        templateUrl: 'components/manageReport/manageReport.html',
        controller: 'ManageReportController'
      }).
      when('/manageReport/:reportId', {
        templateUrl: 'components/manageReport/updateReport.html',
        controller: 'UpdateReportController'
      }).
      when('/viewLog', {
        templateUrl: 'components/viewLog/viewLog.html',
        controller: 'ViewLogController'
      }).
      otherwise({
        redirectTo: '/login'
      });
      $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
  });
