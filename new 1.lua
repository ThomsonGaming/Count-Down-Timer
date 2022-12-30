local screen_width = 1920
local screen_height = 1080

local window = win:new()
window:set_size(screen_width, screen_height)
window:center()
window:set_title("Break Timer")

local label = win:new("label")
label:set_size(screen_width, screen_height)
label:set_align("center")
label:set_font(win.font("Helvetica", 72))
label:set_text_color(win.colors.white)

window:add(label)

print("Enter the duration of the break (in minutes):")
local duration = tonumber(io.read())

local duration_in_seconds = duration * 60

for i = duration_in_seconds, 0, -1 do
  local minutes, seconds = math.modf(i / 60)
  label:set_text(string.format("%02d:%02d", minutes, seconds))
  window:update()
  win.sleep(1000)
end

label:set_text("Time's up!")
window:update()
win.sleep(2000)
window:close()
