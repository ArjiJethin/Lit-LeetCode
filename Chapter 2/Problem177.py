import pandas as pd # type: ignore


def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    unique_salaries = employee.salary.unique()
    if len(unique_salaries) < N:
        return pd.DataFrame([np.NaN], columns=[f"getNthHighestSalary({N})"]) # type: ignore
    else:
        salary = sorted(unique_salaries, reverse=True)[N - 1]
        return pd.DataFrame([salary], columns=[f"getNthHighestSalary({N})"])