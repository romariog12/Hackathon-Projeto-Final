import angular from 'angular';
import uirouter from 'angular-ui-router';

import MesaController from '../controller/mesa.controller';

import mesaService from '../../../servicos/mesa.service';

export default angular.module('myApp.mesa', [uirouter, mesaService])
  .controller('MesaController', MesaController)
  .name;
  