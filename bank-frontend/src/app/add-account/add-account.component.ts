import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from '../account.service';
import { Account } from '../account';

@Component({
  selector: 'app-add-account',
  standalone: false,
  templateUrl: './add-account.component.html',
  styleUrl: './add-account.component.css'
})
export class AddAccountComponent {
  account: Account = { name: '', balance: 0 };

  constructor(private accountService: AccountService, private router: Router) {}

  onSubmit() {
    this.accountService.createAccount(this.account).subscribe(() => {
      // ✅ After saving, navigate to all-details page
      this.router.navigate(['/all-details']);
    });
  }
}
