import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Employee {
  id: number;
  employee_name: string;
  employee_salary: number;
  employee_age: number;
  profile_image: string;
}

export interface EmployeeResponse {
  status: string;
  data: Employee[];
  message: string;
}

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {
  private jsonUrl = 'assets/data/employees.json';

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<EmployeeResponse> {
    return this.http.get<EmployeeResponse>(this.jsonUrl);
  }
}
