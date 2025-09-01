import { Component } from '@angular/core';
import { AccountService } from './account.service';
import { Account } from './account';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  newAccount: Account = { id: 0, name: '', balance: 0 };
  searchName: string = '';
  searchResults: Account[] = [];
  searchError: string = '';

  constructor(private accountService: AccountService) {}

  saveAccount() {
    this.accountService.createAccount(this.newAccount).subscribe(() => {
      alert('Account created successfully!');
      this.newAccount = { id: 0, name: '', balance: 0 };
    });
  }

  searchAccounts() {
    this.accountService.searchAccountsByName(this.searchName).subscribe({
      next: (data) => {
        this.searchResults = data;
        this.searchError = '';
      },
      error: () => {
        this.searchResults = [];
        this.searchError = 'No accounts found!';
      }
    });
  }
}
