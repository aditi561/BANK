import { Component } from '@angular/core';
import { AccountService } from '../account.service';
import { Account } from '../account';

@Component({
  selector: 'app-search-account',
  standalone: false,
  templateUrl: './search-account.component.html',
  styleUrl: './search-account.component.css'
})
export class SearchAccountComponent {
  name: string = '';
  accounts: Account[] = [];

  constructor(private accountService: AccountService) {}

  search() {
    if (!this.name.trim()) {
      this.accounts = [];
      return;
    }

    this.accountService.searchAccountsByName(this.name).subscribe({
      next: (data) => {
        this.accounts = data;
      },
      error: (err) => {
        console.error('Error searching accounts', err);
        this.accounts = [];
      }
    });
  }

}
