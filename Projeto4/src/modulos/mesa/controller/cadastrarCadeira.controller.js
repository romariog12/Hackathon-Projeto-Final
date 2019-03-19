import { inherit } from "@uirouter/core";

export default class CadastrarCadeiraController {

  constructor(mesaService) {
   
    var vm = this;
    this.name = 'CadastrarCadeira';
  
    init();
    function init(){    }
    function salvar(cadeira){
      mesaService.salvar(cadeira).then(function(resp){

      })
    }
  }
}
CadastrarCadeiraController.$inject = ['mesaService'];

