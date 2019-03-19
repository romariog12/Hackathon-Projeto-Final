'use strict';

import angular from 'angular'
import uirouter from 'angular-ui-router';
var blockUI = require('angular-block-ui');

import 'bootstrap';
import './scss/app.scss';

import routing from './app.config';

import mesa from './modulos/mesa/module/mesa.js';
import home from './modulos/home/home.js';
import cadastrarMesa from './modulos/mesa/module/cadastrarMesa';
import cadastrarCadeira from './modulos/mesa/module/cadastrarCadeira';

angular
.module('myApp', [
  uirouter,
  blockUI,
  mesa,
  home,
  cadastrarMesa,
  cadastrarCadeira
])
.config(routing);