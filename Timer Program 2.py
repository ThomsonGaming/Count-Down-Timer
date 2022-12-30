import time
import tkinter as tk

# Set the screen resolution
screen_width = 1920
screen_height = 1080

# Create a Tkinter window
root = tk.Tk()
root.geometry(f'{screen_width}x{screen_height}')
root.title('Break Timer')
root.attributes('-fullscreen', True)

# Set the background color to transparent
root.configure(bg='systemTransparent')
root.attributes('-transparentcolor', 'systemTransparent')

# Create a label to display the countdown timer
label = tk.Label(root, font=('Helvetica', 72), bg='systemTransparent')
label.pack(side='top', fill='both', expand=True)

# Center the label on the screen
label.place(relx=0.5, rely=0.5, anchor='center')

# Prompt the user to enter the duration of the break
duration = int(input("Enter the duration of the break (in minutes): "))

# Convert the duration to seconds
duration_in_seconds = duration * 60

# Display a countdown timer
for i in range(duration_in_seconds, 0, -1):
    minutes, seconds = divmod(i, 60)
    label['text'] = f'{minutes:02}:{seconds:02}'
    root.update()
    time.sleep(1)
    if i <= 30:
        label.flash()

label['text'] = "Time's up!"
root.update()
time.sleep(2)
root.destroy()