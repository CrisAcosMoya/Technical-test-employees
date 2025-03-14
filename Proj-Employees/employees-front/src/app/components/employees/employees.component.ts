import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { EmployeesService } from '../../services/employees.service';


interface Employee {
  id: number;
  employee_name: string;
  employee_salary: number;
  employee_age: number;
  profile_image: string;
}

@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [
    MatInputModule,
    MatButtonModule,
    MatTableModule,
    MatFormFieldModule,
    CommonModule,
    FormsModule
  ],
  templateUrl: './employees.component.html',
  styleUrl: './employees.component.scss'
})
export class EmployeesComponent {
  employeeId: string = '';
  errorMessage: string = '';

  employees: Employee[] = [];
  filteredEmployees: Employee[] = this.employees;

  constructor(private employeesService: EmployeesService) { }

  ngOnInit() {
    this.employeesService.getEmployees().subscribe(response => {
      if (response.status === 'success') {
        this.employees = response.data;
        this.filteredEmployees = this.employees;
      } else {
        // Puedes manejar otros casos o errores
        this.errorMessage = 'Error fetching employees';
      }
    });
  }

  // Función para buscar empleado por ID
  searchEmployee() {
    if (this.employeeId.trim() === '') {
      this.filteredEmployees = this.employees;
      this.errorMessage = '';
    } else {
      const id = Number(this.employeeId);
      const filtered = this.employees.filter(employee => employee.id === id);
      if (filtered.length === 0) {
        this.errorMessage = 'Not Found Employee ID';
      } else {
        this.errorMessage = '';
      }
      this.filteredEmployees = filtered;
    }
  }
}
