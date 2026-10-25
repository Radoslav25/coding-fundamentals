print("Fuel consumption calculator")
try:
    dist = float(input("Enter distance: "))
    cons = float(input("Enter fuel consumption: "))
    price = float(input("Enter fuel price: "))
    if dist < 0 or cons <=0 or price <= 0:
        print("value must be above 0")
    else:
        print("valid values entered")
        print(f"total price is: ${dist/100*cons*price:.2f}")
except ValueError:
    print("Enter a valid number")
