import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css']
})
export class CadastroUsuarioComponent {
  formCadastro: FormGroup;

  constructor(private fb: FormBuilder, private router: Router) {
    this.formCadastro = this.fb.group({
      nome: ['', Validators.required],
      sobrenome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      dataNascimento: ['', Validators.required],
      telefone: ['', Validators.required],
      nomeSupervisor: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.formCadastro.valid) {
      console.log(this.formCadastro.value); // Substitua com a lógica para enviar os dados ao backend
      alert('Usuário cadastrado com sucesso!');
      this.router.navigate(['/']); // Redireciona após o cadastro
    } else {
      alert('Preencha todos os campos corretamente.');
    }
  }

  cancelar(): void {
    this.router.navigate(['/']); // Redireciona ao cancelar
  }
}
