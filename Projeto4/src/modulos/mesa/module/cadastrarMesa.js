import angular from 'angular';
import uirouter from 'angular-ui-router';

import CadastrarMesaController from '../controller/cadastrarMesa.controller';

import mesaService from '../../../servicos/mesa.service';


export default angular.module('myApp.cadastrarMesa', [uirouter, mesaService])
  .controller('CadastrarMesaController', CadastrarMesaController).name;
