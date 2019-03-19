import angular from 'angular';
import uirouter from 'angular-ui-router';

import CadastrarCadeiraController from '../controller/cadastrarCadeira.controller';

import mesaService from '../../../servicos/mesa.service'


export default angular.module('myApp.cadastrarCadeira', [uirouter, mesaService])
  .controller('CadastrarCadeiraController', CadastrarCadeiraController).name;
