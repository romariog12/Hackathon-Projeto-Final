import { inherit } from "@uirouter/core";

export default class CadastrarMesaController {

  constructor(mesaService, $stateParams, $location) {
    var vm = this;
    this.name = 'Cadastrar Mesa';
    init();
    function init() {
      vm.codigo = null;
      vm.mensagem = null;
      if ($stateParams.id) {
        vm.name = 'Editar';
        mesaService.getMesa($stateParams.id).then(function (resp) {
          vm.mesa = resp.data;
          vm.cadeira = { "idCadeira": null, "nome": vm.nomeCadeira, "mesa": vm.mesa };
        })
      } else {
        vm.mesa = { "idMesa": null, "nome": vm.nome, "cadeiras": [] };
      }
    }
    vm.salvar = function () {
      if (vm.nome == 'Editar') {
        mesaService.editar(vm.mesa).then(function (resp) {
          vm.codigo = resp.data.codigo;
          vm.mensagem = resp.data.mensagem;
        })
      } else {
        mesaService.salvar(vm.mesa).then(function (resp) {
          vm.codigo = resp.data.codigo;
          vm.mensagem = resp.data.mensagem;
        })
      }

    }
    //Adcionar cadeira
    vm.adcionarCadeira = function () {
      if (vm.mesa.cadeiras.length < 5) {
        mesaService.adcionarCadeira(vm.cadeira).then(function (resp) {
          init()
          vm.codigo = resp.data.codigo;
          vm.mensagem = resp.data.mensagem;

        })
      } else {
        alert("Limite de cadeiras excedida")
      }

    }
    vm.removerCadeira = function (id) {
      let c = confirm("Tem certeza que deseja excluir?")
      if (c) {
        mesaService.removerCadeira(id).then(function (resp) {
          console.log(resp.data)
          init()
          vm.codigo = resp.data.codigo;
          vm.mensagem = resp.data.mensagem;

        })
      }
      else
        return false;
    }
  }
}

CadastrarMesaController.$inject = ['mesaService', '$stateParams', '$location'];