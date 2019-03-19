import { StateProvider } from "angular-ui-router";

routing.$inject = ['$stateProvider', '$urlRouterProvider'];

export default function routing($stateProvider, $urlRouterProvider) {
    let homeState = {
        name: 'home',
        url: '/home',
        templateUrl: './modulos/home/home.view.html',
        controller: 'HomeController',
        controllerAs: 'vm'
      }
      $stateProvider.state(homeState);
    let mesaState = {
        name: 'mesa',
        url: '/mesa',
        templateUrl: './modulos/mesa/view/mesa.view.html',
        controller: 'MesaController',
        controllerAs: 'vm'
      }
    $stateProvider.state(mesaState);
    let cadastrarMesaState = {
      name:'cadastrarMesa',
      url:'/mesa/cadastrar',
      templateUrl:'./modulos/mesa/view/cadastrarMesa.view.html',
      controller: 'CadastrarMesaController',
      controllerAs:'vm'
    }
    $stateProvider.state(cadastrarMesaState)
   
    let editarMesaState = {
      name:'editarMesa',
      url:'/mesa/editar/:id',
      templateUrl:'./modulos/mesa/view/cadastrarMesa.view.html',
      controller: 'CadastrarMesaController',
      controllerAs:'vm'
    }
    $stateProvider.state(editarMesaState)
    $urlRouterProvider.otherwise('/home')
}